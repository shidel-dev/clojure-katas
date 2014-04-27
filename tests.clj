(ns tests
(:require [clojure.test :refer :all]))
(load-file "lists.clj")
(load-file "math.clj")

;lists

(deftest last-box
  (is (= (lists/my-last '(a b c d)) '(d))))

(deftest last-plus-one-box
  (is (= (lists/my-but-last '(a b c d)) '(c d))))

(deftest palindrome
  (is (= (lists/is-palindrome '(a b c b a)) true))
  (is (= (lists/is-palindrome '(a b c b z)) false)))


(deftest compress
   (is (= (lists/compress '(a a a a b c c a a d e e e e)) '(a b c a d e))))

(deftest pack
   (is (= (lists/pack '(a a a a b c c a a d e e e e)) '((a a a a) (b) (c c) (a a) (d) (e e e e)))))


(deftest encode
   (is (=  (lists/encode '(a a a a b c c a a d e e e e)) '((4 a) (1 b) (2 c) (2 a) (1 d)(4 e)))))


(deftest decode
  (is (= (lists/decode '((4 a) (1 b) (2 c) (2 a) (1 d)(4 e))) '(a a a a b c c a a d e e e e))))

(deftest repli
  (is (= (lists/repli  '(a b c) 3) '(a a a b b b c c c))))


;math

(deftest Euclidean-gcd
  (is (= (math/gcd 36 63) 9)))

(deftest coprime
  (is (= (math/coprime 35 64) true)))


(deftest totient-phi
  (is (= (math/totient 10) 4)))


(run-tests)

