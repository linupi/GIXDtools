set terminal pngcairo
filename='TOP3_'

set style fill solid 1.00 border lt -1

param="a"
set output filename.param.".png"
plot filename.param.".txt" using 1:2 with boxes title param

param="b"
set output filename.param.".png"
plot filename.param.".txt" using 1:2 with boxes title param

param="c"
set output filename.param.".png"
plot filename.param.".txt" using 1:2 with boxes title param

param="alpha"
set output filename.param.".png"
plot filename.param.".txt" using 1:2 with boxes title param

param="beta"
set output filename.param.".png"
plot filename.param.".txt" using 1:2 with boxes title param

param="gamma"
set output filename.param.".png"
plot filename.param.".txt" using 1:2 with boxes title param
