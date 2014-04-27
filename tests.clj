(ns lists-tests
(:require [clojure.test :refer :all]))
(load-file "lists.clj")

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



(run-tests)

