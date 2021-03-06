DESCRIPTION = "RPi Image with Xenoamai, a real-time OS"

PREFERRED_PROVIDER_virtual/kernel ?= "linux-xenomai-rpi"

IMAGE_FEATURES += "splash package-management ssh-server-openssh tools-sdk \
                     ${CORE_IMAGE_BASE_INSTALL}"

LICENSE = "MIT"

inherit core-image

IMAGE_INSTALL_append = " xenomai"
