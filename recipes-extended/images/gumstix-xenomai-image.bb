DESCRIPTION = "Image with Xenoamai, a real-time OS"

IMAGE_FEATURES += "splash package-management ssh-server-openssh tools-sdk \
                     ${CORE_IMAGE_BASE_INSTALL}"

LICENSE = "MIT"

inherit core-image

#install firmware-sd8686 for wireless issue
IMAGE_INSTALL_append = " linux-firmware-sd8686 xenomai"
