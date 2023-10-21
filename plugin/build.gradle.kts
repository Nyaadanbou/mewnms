import net.minecrell.pluginyml.paper.PaperPluginDescription

plugins {
    id("cc.mewcraft.deploy-conventions")
    alias(libs.plugins.pluginyml.paper)
}

project.ext.set("name", "MewNMS")

dependencies {
    // helper
    compileOnly(libs.helper)

    // server
    compileOnly(libs.server.paper)

    // internal
    implementation(project(":mewnms:api"))
    // implementation(project(":mewnms:v1_19_r3", configuration = "reobf")) // Not used anymore
    implementation(project(":mewnms:v1_20_r1", configuration = "reobf"))
    implementation(project(":mewnms:v1_20_r2", configuration = "reobf"))
}

paper {
    main = "cc.mewcraft.nms.MewNMSPlugin"
    name = project.ext.get("name") as String
    version = "${project.version}"
    description = project.description
    apiVersion = "1.19"
    authors = listOf("Nailm")
    serverDependencies {
        register("helper") {
            required = true
            load = PaperPluginDescription.RelativeLoadOrder.BEFORE
        }
    }
}
