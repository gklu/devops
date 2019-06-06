pipelineJob('icdc/c9c') {
  definition  {
    cps {
      script("""\
        pipeline {
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
                TOMCAT_IP = "${TOMCAT_IP}"
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
                withCredentials([usernamePassword(credentialsId: 'c9c-deployer', passwordVariable: 'deployer_password', usernameVariable: 'deployer')]) {
                  sh "set +x"
                  sh 'cd target && curl -T "RESTFfullDemo.war" "http://$deployer:$deployer_password@$TOMCAT_IP/manager/text/deploy?path=/RESTFfullDemo&update=true"'
                }
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