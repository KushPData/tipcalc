# tipcalc
Repository for INFO 448 Assignment, Tip Calculator

Extra Credit:
To make sure that only two decimal points ever appear, I used the following line of code: 

String.format("%.2f", tip)

Moreover, to make sure the math is always correct, I first converted the dollar amount to cents. Then, I calculated the tip by multiplying the cents by 0.15. Finally, I converted the tip (in cents) to dollar amount by dividing by 100.0