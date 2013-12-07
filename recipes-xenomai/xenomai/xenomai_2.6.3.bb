DESCRIPTION = "Provides userspace xenomai support and libraries needed to for \
real-time applications using the xenomai RTOS implementation"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://include/COPYING;md5=60faa041c8d4a75ab87e115a9469d94d"
SECTION = "xenomai"
HOMEPAGE = "http://www.xenomai.org/"
PR = "r0"

SRC_URI = "http://download.gna.org/xenomai/stable/xenomai-2.6.3.tar.bz2"


S = "${WORKDIR}/xenomai-${PV}"

inherit autotools

includedir = "/usr/include/xenomai"

#Fixes QA Issues: non debug package contains .debug directory
FILES_${PN}-dbg += "/usr/bin/regression/posix/.debug"
FILES_${PN}-dbg += "/usr/bin/regression/native/.debug"
FILES_${PN}-dbg += "/usr/bin/regression/native+posix/.debug"

# Fixes QA Error - Non -dev package contains symlink .so
FILES_${PN}-dev += "/usr/lib/*.se"

#Add directories to package for shipping
FILES_${PN} += "/dev/*"
FILES_${PN} += "/usr/bin/*"
FILES_${PN} += "/usr/lib/*"
FILES_${PN} += "/usr/sbin/*"\
FILES_${PN} += "/usr/include/*"
FILES_${PN} += "/usr/lib/*"
FILES_${PN} += "/usr/share/doc/*"
FILES_${PN} += "/usr/share/man/*"

SRC_URI[md5sum] = "9f83c39cfb10535df6bf51702714e716"
SRC_URI[sha256sum] = "4d0d09431f0340cf4c9e2745177f77f15b7b124f89982035d1d3586519d7afe9"
