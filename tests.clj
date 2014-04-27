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

(deftest prime-factors
  (is (= (math/prime-factors 315) '(3 3 5 7))))


; from exercism.io

(load-file "crypto_square.clj")

(deftest normalize-splunk
  (is (= "splunk" (normalize-plaintext "s#!@$%plunk"))))
(deftest normalize-with-punctuation
  (is (= "123go" (normalize-plaintext "1, 2, 3 GO!"))))

(deftest square-2
  (is (= 2 (square-size "1234"))))
(deftest square-3
  (is (= 3 (square-size "123456789"))))
(deftest square-4
  (is (= 4 (square-size "123456789abc"))))

(deftest segments
  (is (= ["neverv", "exthin", "eheart", "withid", "lewoes"]
         (plaintext-segments "Never vex thine heart with idle woes."))))
(deftest segments-2
  (is (= ["zomg", "zomb", "ies"]
         (plaintext-segments "ZOMG! ZOMBIES!!!"))))

(deftest cipher-1
  (is (= "tasneyinicdsmiohooelntuillibsuuml"
         (ciphertext "Time is an illusion. Lunchtime doubly so."))))
(deftest cipher-2
  (is (= "wneiaweoreneawssciliprerlneoidktcms"
         (ciphertext "We all know interspecies romance is weird."))))
(deftest cipher-3
  (is (= "msemo aanin dninn dlaet ltshu i"
         (normalize-ciphertext "Madness, and then illumination."))))
(deftest cipher-4
  (is (= "vrela epems etpao oirpo"
         (normalize-ciphertext "Vampires are people too!"))))




(run-tests)

