DESCRIPTION = "Provides userspace xenomai support and libraries needed to for \
real-time applications using the xenomai RTOS implementation"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://include/COPYING;md5=60faa041c8d4a75ab87e115a9469d94d"
SECTION = "xenomai"
HOMEPAGE = "http://www.xenomai.org/"
PR = "r0"

SRC_URI = "file://files/xenomai-${PV}.tar.gz"


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


