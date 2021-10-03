type bool_expr =
  | Lit of string
  | Not of bool_expr
  | And of bool_expr * bool_expr
  | Or of bool_expr * bool_expr ;;


  let rec truth_table_helper a b expression bool_a bool_b = 
    match expression with 
    |Lit ab  -> if ab = a then bool_a else bool_b 
    |Not express -> not(truth_table_helper a b express bool_a bool_b)
    |And (val_a, val_b)-> (truth_table_helper a b val_a bool_a bool_b) && (truth_table_helper a b val_b bool_a bool_b)
    |Or(val_a, val_b) -> (truth_table_helper a b val_a bool_a bool_b) || (truth_table_helper a b val_b bool_a bool_b);
  
  ;;
let truth_table a b expression  = 
  (*(truth-value-of-first-literal, truth-value-of-second-literal, truth-value-of-expression)*)
  [(true, true, truth_table_helper a b expression true true);
  (false, false, truth_table_helper a b expression false false);
  (false, true, truth_table_helper a b expression false true);
  (true, false, truth_table_helper a b expression true false;)]


;;

