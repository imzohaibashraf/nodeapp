def slack_code(){
       slackSend(
                 color: color_slack_msg(),
                 message: """
                     *${currentBuild.currentResult}:* Job `${env.JOB_NAME}` build `${env.BUILD_DISPLAY_NAME}`>
                      More info at: ${env.BUILD_URL}
                      Time: ${currentBuild.durationString.minus(' and counting')}
                      """
              )
}
def color_slack_msg() {
    switch(currentBuild.currentResult) {
    case "SUCCESS":
        return "#2EB67D"
        break
    case "FAILURE":
    case "UNSTABLE":
        return "#E01E5A"
        break
    default:
        return "#ECB22E"
        break
    }
}