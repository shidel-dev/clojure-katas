(ns lists)

(defn my-last [li]
  (take-last 1 li))

(defn my-but-last [li]
  (take-last 2 li))

(defn is-palindrome [li]
  (= li (reverse li)))


(defn compress [li]
  (loop [compLi '() curLi (reverse li)]
    (if (empty? curLi) compLi
      (recur (conj compLi (first curLi)) (drop-while #(= % (first curLi)) curLi)))))


(compress '(a a a a b c c a a d e e e e))
