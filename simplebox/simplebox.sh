#!/bin/sh

#                      My Simple Development Box
#
# 1. Install debian using netinst image (select standard utilities packages only)
# 2. Boot into your new system and run this script
# 3. Copy configuration files and restart
#    cp rules.v4 /etc/iptables/
#    cp sysctl.conf /etc/


apt-get -y install net-tools
apt-get -y install iptables-persistent
apt-get -y install vim
apt-get -y install xserver-xorg-core
apt-get -y install xinit
apt-get -y install xserver-xorg-input-all
apt-get -y install openbox
apt-get -y install obconf
apt-get -y install obmenu
apt-get -y install suckless-tools
apt-get -y install menu
apt-get -y install lxterminal
apt-get -y install nmap
apt-get -y install iceweasel
apt-get -y install default-jdk
apt-get -y install openjdk-11-jdk
apt-get -y install maven
apt-get -y install rsync
apt-get -y install git
apt-get -y install byzanz
apt-get -y install curl
apt-get -y install nitrogen
apt-get -y install gdmap
apt-get -y install gimp
apt-get -y install gnupg
apt-get -y install gpicview
apt-get -y install graphviz
apt-get -y install keepassx
apt-get -y install mousepad
apt-get -y install links2
apt-get -y install lxrandr
apt-get -y install orpie
apt-get -y install parted
apt-get -y install vlc
apt-get -y install wipe
apt-get -y install xfburn
apt-get -y install xsane
apt-get -y install ant
apt-get -y install zip
apt-get -y install qpdfviewer
apt-get -y install netselect-apt
apt-get -y install stopwatch
apt-get -y install vym
apt-get -y install aumix
apt-get -y install xfce4-screenshooter
apt-get -y install simplescreenrecorder
apt-get -y install lightdm
apt-get -y install libreoffice
apt-get -y remove xterm
apt autoremove