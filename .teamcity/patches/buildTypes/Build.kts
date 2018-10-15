package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.VcsTrigger
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2018_1.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with id = 'Build'
accordingly, and delete the patch script.
*/
changeBuildType(RelativeId("Build")) {
    expectSteps {
    }
    steps {
        insert(0) {
            script {
                scriptContent = """
                    curl https://github.com/GitTools/GitVersion/archive/v4.0.0.zip --output GitVersion.zip -LO
                    unzip GitVersion.zip -d GitVersion
                """.trimIndent()
            }
        }
    }

    triggers {
        val trigger1 = find<VcsTrigger> {
            vcs {
            }
        }
        trigger1.apply {
            branchFilter = ""
            perCheckinTriggering = true
            groupCheckinsByCommitter = true
            enableQueueOptimization = false
        }
    }
}
