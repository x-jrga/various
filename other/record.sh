#!/bin/sh

unset x y w h
  eval $(xwininfo -id $(xdotool getactivewindow) |
    sed -n -e "s/^ \+Absolute upper-left X: \+\([0-9]\+\).*/x=\1/p" \
           -e "s/^ \+Absolute upper-left Y: \+\([0-9]\+\).*/y=\1/p" \
           -e "s/^ \+Width: \+\([0-9]\+\).*/w=\1/p" \
           -e "s/^ \+Height: \+\([0-9]\+\).*/h=\1/p" )

x=$((x-4));
y=$((y-22));
w=$((w+8));
h=$((h+30));

byzanz-record -d 5 --delay=1 -x $x -y $y -w $w -h $h ~/Videos/animation.gif
