type expr =  
  |Const of int
  |Plus of {arg1: expr; arg2:expr}
  |Mult of {arg1: expr; arg2:expr}
  |Minus of {arg1: expr; arg2:expr}
  |Div of {arg1: expr; arg2:expr}

let rec evaluate expression = 
  match expression with 
  |Const x -> x
  |Plus x -> evaluate x.arg1 + evaluate x.arg2
  |Mult x -> evaluate x.arg1 * evaluate x.arg2
  |Minus x -> evaluate x.arg1 - evaluate x.arg2
  |Div x -> evaluate x.arg1 / evaluate x.arg2 ;; 

  


