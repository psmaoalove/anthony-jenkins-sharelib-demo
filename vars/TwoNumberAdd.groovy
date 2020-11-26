
def call(int a, int b) {
        try {
            timeout(1){
                //等待sonarqube的分析结果，这里是等1分钟
                echo "未通过SonarQube的代码检查，请及时修改!"
                currentBuild.result = 'FAILED'
            }
        }catch (exc){
            echo 'Something failed, I should sound the klaxons!'
        }
    }






