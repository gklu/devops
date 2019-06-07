pipelineJob('icdc/c9c') {

  def repo = 'https://github.com/gklu/devops.git' 
  description("ICDC pipeline Job") 

  definition  {
    cpsScm {
      scm {
        git {
          remote { url(repo) }
          branches('master', '**/feature*')
          scriptPath('jobs/icdc/Jenkinsfile')
          extensions { }  // required to avoid tagging
        }
      }
    }
  }
}