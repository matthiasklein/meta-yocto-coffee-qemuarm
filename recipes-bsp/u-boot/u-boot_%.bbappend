FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://enable-env-ext4.cfg \
            "
do_deploy:append() {
	# Generate env image
	${B}/tools/mkenvimage -s ${UBOOT_ENV_SIZE} -o ${DEPLOYDIR}/uboot.env ${DEPLOYDIR}/${UBOOT_INITIAL_ENV}
}
