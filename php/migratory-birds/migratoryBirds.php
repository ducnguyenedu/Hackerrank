<?php
/*
 * Complete the 'migratoryBirds' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY arr as parameter.
 */
function migratoryBirds($arr) {
    // Write your code here
    $temp = [];
    $count = array_count_values($arr);
    foreach ($count as $key => $val){
        if($val === max($count)) $temp[] = $key;
    }
    return min($temp);
}
$fptr = fopen(getenv("OUTPUT_PATH"), "w");
$arr_count = intval(trim(fgets(STDIN)));
$arr_temp = rtrim(fgets(STDIN));
$arr = array_map('intval', preg_split('/ /', $arr_temp, -1, PREG_SPLIT_NO_EMPTY));
$result = migratoryBirds($arr);
fwrite($fptr, $result . "\n");
fclose($fptr);
