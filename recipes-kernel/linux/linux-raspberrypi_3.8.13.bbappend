
FILESEXTRAPATHS_prepend := "${THISDIR}/{PN}"

SRC_URI += "http://download.gna.org/xenomai/stable/xenomai-2.6.3.tar.bz2"

#commented out, need to download and extract xenomai. Patch kernel then apply prepare_kernel.sh
#SRC_URI +=  "file://ipipe-core-3.8.13-raspberry-pre-2.patch;md5=9a6c29cb91963144522340f45d0cb7e8"
#SRC_URI +=  "file://ipipe-core-3.8.13-arm-3.patch;md5=99f1bd34259199fb410d2052eb2f947d"
#SRC_URI +=  "file://ipipe-core-3.8.13-raspberry-post-2.patch;md5=2355877c2844f65a901f90ddc233aa3f"
#SRC_URI +=  "file://defconfig"


do_prepare_kernel () {

    #add step for finding the xenomai extracted tar
    #then 
    #1. apply ipipe-core-3.8.13-raspberry-pre-2.patch
    #2. apply ipipe-core-3.8.13-arm-3.patch
    #3. apply ipipe-core-3.8.13-raspberry-post-2.patch
    #4. execute prepare_kernel.sh --linux=<linux> --arch=arm
    echo "Hello, world!"

}

addtask prepare_kernel after do_populate_sysroot before do_patch

