
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRC_URI += "file://0001-xenomai-2.6.2.1-kernel.patch;md5=51901d6f88aa3d077e293fb64ef47f8f \
            file://0001-fix-implicit-reference.patch;md5=a3150ebcd0b3eef200e500c96ea7fed6 \
            file://0001-fix-added-__und_svc_finish.patch;md5=05a424b5b8148c9f12547e079c94e147 \
            file://defconfig \
            "

