-- @Author: hiru
-- @Date:   2017-11-20T23:08:10+00:00
-- @Last modified by:   hiru
-- @Last modified time: 2017-11-23T14:57:12+00:00
import Data.Char
import Data.List

inRange :: Int -> Int -> [Int] -> [Int]
inRange start end [] = []
inRange start end (x:xs) | x >= start && x <= end = x : inRange start end xs
                          | otherwise = inRange start end xs

countPositives :: [Int] -> [Int]
countPositives [] = []
countPositives (x:xs) | x > 0 = x : countPositives xs
                      | otherwise = countPositives xs

capitalised :: String -> String
capitalised "" = ""
capitalised (x:xs) = toUpper x : restLower xs

restLower :: String -> String
restLower "" = ""
restLower (x:xs) = toLower x : restLower xs

title :: [String] -> [String]
title [] = []
title (x:xs) = capitalised x : title xs

isort :: Ord a => [a] -> [a]
isort [] = []
isort (x:xs) = insert (isort xs)
  where insert [] = [x]
        insert (y:ys)
          | x < y = x : y : ys
          | otherwise = y : insert ys

merge :: Ord a => [a] -> [a] -> [a]
merge [] [] = []
merge [] ys = ys
merge xs [] = xs
merge (x:xs) (y:ys) | x > y = y : merge (x:xs) ys
                    | otherwise = x : merge xs (y:ys)

msort :: Ord a => [a] -> [a]
msort [] = []
msort [x] = [x]
msort list = merge (msort (take (div (length list) 2) list)) (msort (drop (div (length list) 2) list))

rotor :: Ord a =>  Int -> [a] -> [a]
rotor offset input | offset == 0 = error "Error has zero offset"
                  | offset >= length input = error "Error offset larger than input length"
                  | otherwise = take (length input) (drop offset input) ++ take offset input

-- Keys given in uppercase only
makeKey :: Int -> [(Char,Char)]
makeKey offset = zip (alphabet) (rotor offset alphabet)
    where alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

lookUp :: Char -> [(Char, Char)] -> Char
lookUp searchFor (x:xs) | fst x == searchFor = snd x
                        | otherwise = lookUp searchFor (drop 1 (x:xs))

encipher :: Int -> Char -> Char
encipher offset letter = lookUp letter (makeKey offset)

normalise :: String -> String
normalise "" = ""
normalise (x:xs) | isLetter x == True = toUpper x : normalise xs
                  | isDigit x == True = x : normalise xs
                  | otherwise = normalise xs

encipherStr :: Int -> String -> String
encipherStr offset "" = ""
encipherStr offset text = [encipher offset x | x <- (normalise text)]
