pipelineJob('icdc/c9c') {
  definition  {
    cps {
      script("""\
        pipeline {
          environment {
            FOO = credentials("c9c-deployer")
          }
          agent {
            node {
              label 'icdc_maven'
            }
          }
          options {
            timestamps()
          }
          tools { 
            maven 'maven-3.6.1' 
            jdk 'jdk11' 
          }
          stages {
            stage('Checkout') {
              steps {
                git branch: 'master',
                url: 'https://github.com/jonkiky/neo4j_for_testing.git'
              }
            }
            stage('Build') {
              environment {
                TOMCAT_IP = "$TOMCAT_IP"
              }
              steps {
                sh "mvn package"
                sh "mv target/RESTFfullDemo-0.0.1-SNAPSHOT.war target/RESTFfullDemo.war"
              }
            }
            stage('Deploy') {
              when {
                expression {
                currentBuild.result == null || currentBuild.result == 'SUCCESS' 
                }
              }
              steps {
                sh 'echo "FOO is $FOO"'
                sh 'echo "FOO_USR is $FOO_USR"'
                sh 'echo "FOO_PSW is $FOO_PSW"'
            }
          }
        }
          post {
            always {
              slackSend(channel: '#random', message: 'My first Jenkins build')
            }
          }
        }""".stripIndent())
      
    }
  }
}