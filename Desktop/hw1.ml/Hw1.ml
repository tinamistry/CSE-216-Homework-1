let rec pow x n = 
  if n == 0 then 
  1
else if n == 1 then 
 x
 else 
 x * pow x (n-1);;


let rec float_pow x n = 
   if n == 0 then 
   1.0
   else if n == 1 then 
   x 
   else 
   x *. float_pow x (n-1);;

  
   let rec compress lst  = 
    match lst with 
    |[] -> []
    |[head] -> [head]
    |head :: (head_of_tail) -> if head = head_of_tail then (compress(head_of_tail::tail)) else head::(compress(head_of_tail));;

   
let rec remove_if list p = 
  match list with 
  |[] -> []
  |head::tail -> if p head = true then remove_if tail p else head::(remove_if tail p);;
  



  




   
