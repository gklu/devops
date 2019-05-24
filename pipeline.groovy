pipelineJob('testjobs/default-agent') {
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
          stages {
            stage('Checkout') {
              steps {
                git branch: 'master',
                    url: 'https://github.com/jonkiky/neo4j_for_testing.git'
                }
            }
            stage('Build') {
              steps {
                withMaven(maven: 'maven-3.6.1') {
                    sh "mvn package"
                    sh "cd target"
                    sh "mv RESTFfullDemo-0.0.1-SNAPSHOT.war RESTFfullDemo.war"
                }
              }
            }
          stage('Deploy') {
            when {
              expression {
                currentBuild.result == null || currentBuild.result == 'SUCCESS' 
              }
            }
            steps {
                environment {
                //MATCH_CREDS = credentials('match')
                echo "SUCCESS"
                def attachments = [
                [
                    text: 'simple job logs',
                    fallback: 'Need to check this',
                    color: '#ff0000'
                    ]
                ]
                slackSend(channel: '#random', attachments: attachments)
            }
          }
        }
      }""".stripIndent())
    }
  }
}