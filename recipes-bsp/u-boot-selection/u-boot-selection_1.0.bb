SUMMARY = "U-Boot selection script"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS = "u-boot-mkimage-native"

B = "${WORKDIR}/build"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "file://u-boot-selection"

inherit deploy

do_compile () {
	mkimage -T script -C none -n 'boot selection script' -d ${WORKDIR}/u-boot-selection u-boot-selection.img
}

do_install () {
	install -d ${D}/etc
	install -m 644 ${B}/u-boot-selection.img ${D}/etc/
}

do_deploy () {
	install -m 644 ${B}/u-boot-selection.img ${DEPLOYDIR}/u-boot-selection.img
}

addtask deploy before do_build after do_compile

