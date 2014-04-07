require linux-raspberrypi.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}"

#download linux src tree
SRCREV = "d996a1b91b2bf3dc06f4f4f822a56f4496457aa1"
SRC_URI += "git://github.com/raspberrypi/linux.git;protocol=git;branch=rpi-3.8.y"

#xenomai source (prepare_kernel.sh script)
SRC_URI += "http://download.gna.org/xenomai/stable/xenomai-2.6.3.tar.bz2"

#Kernel patches for xenomai
SRC_URI +=  "file://ipipe-core-3.8.13-raspberry-pre-2.patch;md5=9a6c29cb91963144522340f45d0cb7e8"
SRC_URI +=  "file://ipipe-core-3.8.13-arm-3.patch;md5=99f1bd34259199fb410d2052eb2f947d"
SRC_URI +=  "file://ipipe-core-3.8.13-raspberry-post-2.patch;md5=2355877c2844f65a901f90ddc233aa3f"

#kernel defconfig
SRC_URI +=  "file://defconfig"


do_prepare_kernel () {

    #add step for finding the xenomai extracted tar
    #then 
    #1. apply ipipe-core-3.8.13-raspberry-pre-2.patch
    #2. apply ipipe-core-3.8.13-arm-3.patch
    #3. apply ipipe-core-3.8.13-raspberry-post-2.patch
    #4. execute prepare_kernel.sh --linux=<linux> --arch=arm

    #set linux kernel source directory
    linux_src="${S}"
    echo $linux_src > ~/test.tmp

    #set xenomai source directory 
    xenomai_src="${TMPDIR}/work/${MACHINE}-poky-${TARGET_OS}/${PN}/${EXTENDPE}${PV}-${PR}/xenomai-2.6.3/"
    echo $xenomai_src > ~/test2.tmp

    #prepare kernel
    $xenomai_src/scripts/prepare-kernel.sh --arch=arm --linux=$linux_src

    #switch pwd to xenomai source root
    pushd $xenomai_src


    #xenomai root working directory
    pwd > ~/test3.tmp

    #switch pwd back to bitbake default
    popd

    pwd > ~/test4.tmp


}

addtask prepare_kernel after do_patch before do_configure

