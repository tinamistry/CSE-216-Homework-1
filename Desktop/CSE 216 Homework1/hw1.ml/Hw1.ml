(*------------------Part 1 Q1--------------------*)
let rec pow x n :int = 
  if n == 0 then 
  1
else if n == 1 then 
 x
 else 
 x * pow x (n-1);;
let rec float_pow x n :float= 
   if n == 0 then 
   1.0
   else if n == 1 then 
   x 
   else 
   x *. float_pow x (n-1);;

(*----------Part 1 Q2-------------------*)
let rec compress lst  = 
    match lst with 
    |[] -> []
    |[head] -> [head]
    |head :: head_of_tail::tail -> if head = head_of_tail then (compress(head_of_tail::tail)) else head::(compress(head_of_tail::tail));;
  

(*------------------Part 1 Q3---------------------*)  
let rec remove_if lst p = 
  match lst with 
  |[] -> []
  |head::tail -> if p head = true then remove_if tail p else head::(remove_if tail p);;

 
(*---------------------Part 1 Q4----------------------*)
let rec slice_j lst j  = 
  match lst with 
  |[] -> []
  |head :: tail -> if j = 0 then [] else  head :: slice_j tail (j-1);;

let rec slice_i lst i = 
  match lst with 
  |[] -> []
  |head :: tail -> if i = 0 then lst else slice_i tail (i-1)

let slice lst i j = 
  match lst with 
  |[] -> []
  |head :: tail -> if i > j then [] else slice_i (slice_j lst j ) i ;;
  

(*---------------------Part 1 Q5-----------------*)
(*let rec equivs_helper1 f lst = 
  match lst with 
  |[] -> []
  |head::tail -> if (f head)then (head :: equivs_helper1(f tail)) else ((equivs_helper1(f tail) );; 
  
  let rec equivs_helper2 f lst = 
    match lst with 
    |[]-> []
    |head::tail -> if !(f head) then (head :: equivs_helper(f tail)) else (equivs_helper(f tail))

let equivs f lst = 
  match lst with 
  |[] -> [[]]
  |h::t  ->  equivs_helper1(f lst) :: equivs_helper2(f lst)*)





(*----------------Part 1 Q6------------------------*)
let check_if_prime n :bool = 
  if (n<=2 || n mod 2 = 0) then false else true 
  ;;

let goldbachpair num  = 
  let rec helper i = 
    if (check_if_prime i = true && (check_if_prime (num-i)) = true) then (i, num-i)
    else 
    helper(i + 1) 
    in helper 0 ;;
(*---------------------Part 1 Q7-----------------------*)
let rec equiv_on f g lst : bool =
       match lst with 
       |[] -> true
       |head::tail  -> if (f head) = (g head) 
       then equiv_on f g tail 
       else 
       false ;; 

(*-----------------Part 1 Q8-----------------*)
let rec pairwisefilter cmp lst  = 2
          match lst with 
          | [] -> []
          |[head] -> [head]
          |head::head_of_tail::tail -> if (cmp head head_of_tail) = head then head :: (pairwisefilter cmp tail) 
          else head_of_tail :: (pairwisefilter cmp tail );;


(* ---------------Part 1 Q9----------------*)
let  rec polynomial lst n = 
            match lst with 
            |[] -> 0
            |(num,exp)::tail -> (num * (pow n exp)) + polynomial tail n ;;

(*-------- Part 1 Q10------------------*)

let rec powerset lst : 'a list = 
  match lst with 
  |[] -> []
  |head::tail -> [head] :: (powerset tail);;

let rec powerset_helper lst : 'a list list  = 
  match lst with 
  |[[]] -> [[]]
  |(_::_)::[]->[]
  |[]::[] -> []
  |head::next::tail -> [head@next] :: (powerset_helper (head::tail));;




