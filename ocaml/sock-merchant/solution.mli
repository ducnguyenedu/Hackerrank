open Scanf
open Printf
external id: 'a -> 'a = "%identity"
let () =
  let n = scanf "%u " id in
  let c = Array.make 105 0 in
  for i = 1 to n do
    scanf "%u " begin fun a ->
      c.(a) <- c.(a) + 1
    end
  done;
  printf "%u" @@ Array.fold_left (fun prev a -> if a > 0 then prev + a/2 else prev) 0 c
