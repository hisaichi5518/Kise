release:
	git tag `cat VERSION`
	git push origin `cat VERSION`
	./gradlew clean build bintrayUpload -PbintrayUser=hisaichi5518 -PbintrayKey=${BINTRAY_API_TOKEN} -PdryRun=true
