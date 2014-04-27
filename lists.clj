(ns lists)

(defn my-last [li]
  (take-last 1 li)
)

(defn my-but-last [li]
  (take-last 2 li)
)

(defn is-palindrome [li]
  (= li (reverse li))
)

