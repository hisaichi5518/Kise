release:
	./gradlew clean build bintrayUpload -PbintrayUser=hisaichi5518 -PbintrayKey=${BINTRAY_API_TOKEN} -PdryRun=true
