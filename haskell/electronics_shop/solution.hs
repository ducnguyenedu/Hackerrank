{-# LANGUAGE FlexibleInstances, UndecidableInstances, DuplicateRecordFields #-}

module Main where

import Control.Monad
import Data.List
import Data.List.Split
import Data.Set
import System.Environment
import System.IO

--
-- Complete the getMoneySpent function below.
--
getMoneySpent :: [Int] -> [Int] -> Int -> Int
getMoneySpent keyboards drives b
    --
    -- Write your code here.
    --
    | Data.List.null combos = (-1)
    | otherwise = maximum combos
    where combos = [x + y | x <- keyboards, y <- drives, x + y <= b]
    -- End
readMultipleLinesAsStringArray :: Int -> IO [String]
readMultipleLinesAsStringArray 0 = return []
readMultipleLinesAsStringArray n = do
    line <- getLine
    rest <- readMultipleLinesAsStringArray(n - 1)
    return (line : rest)

main :: IO()
main = do
    stdout <- getEnv "OUTPUT_PATH"
    fptr <- openFile stdout WriteMode

    bnmTemp <- getLine
    let bnm = words bnmTemp

    let b = read (bnm !! 0) :: Int

    let n = read (bnm !! 1) :: Int

    let m = read (bnm !! 2) :: Int

    keyboardsTemp <- getLine

    let keyboards = Data.List.map (read :: String -> Int) . words $ keyboardsTemp

    drivesTemp <- getLine

    let drives = Data.List.map (read :: String -> Int) . words $ drivesTemp

    --
    -- The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
    --

    let moneySpent = getMoneySpent keyboards drives b

    hPutStrLn fptr $ show moneySpent

    hFlush fptr
    hClose fptr
