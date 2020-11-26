
def call(int a, int b) {
    container('git') {
        script {
            git(url: "https://oauth2:2181b1955b6a5d98c5a2faf5ade00da07fd90b60@github.com/xiexiongmaojun/hello-world.git" , credentialsId: '', branch: "master")
        }
    }
    withSonarQubeEnv('SonarQube') {
        container('sona') {
            script {
                sh '/sonar/bin/sonar-scanner -Dsonar.projectKey=pevdd -Dsonar.sources=. -Dsonar.language=java '
            }
        }
    }
    script {
        try {
            timeout(1){
                //等待sonarqube的分析结果，这里是等1分钟
                def qg = waitForQualityGate()
                if (qg.status != 'OK') {
                    error "未通过SonarQube的代码检查，请及时修改! failure: ${qg.status}"
                    echo "未通过SonarQube的代码检查，请及时修改!"
                    currentBuild.result = 'FAILED'
                }
            }
        }catch (exc){
            echo 'Something failed, I should sound the klaxons!'
        }
    }

}






