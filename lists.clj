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

(defn pack [li]
  (loop [compLi '() curLi (reverse li)]
    (if (empty? curLi) compLi
      (recur (conj compLi (take-while #(= % (first curLi)) curLi)) (drop-while #(= % (first curLi)) curLi)))))


(defn encode [li]
  (map #(conj (take 1 %)(count %))(pack li)))


(defn decode [li]
  (mapcat #(take (first %) (repeatedly (fn [](second %)))) li))


(defn repli [li n]
  (mapcat #(repeat n %) li))




