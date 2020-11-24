
def call(int a, int b) {
    
pipeline {
    agent  any
    stages {
        //下载代码
        stage("GetCode"){ //阶段名称
            steps{  //步骤
             echo '333'
            }
        }
    }

}

}
