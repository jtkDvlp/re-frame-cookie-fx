(ns re-frame-cookie-fx.cookie
  (:refer-clojure :exclude [get reset!])
  (:require [cljs.reader :refer [read-string]])
  (:import goog.net.cookies))

(defn get
  ([key]
   (get key nil))

  ([key not-found]
   (let [cookies goog.net.cookies
         key (str key)]
     (if (.containsKey cookies key)
       (read-string (.get cookies key))
       not-found))))

(defn reset! [key val]
  (.set goog.net.cookies
        (str key)
        (pr-str val)))

(defn remove! [key]
  (.remove goog.net.cookies (str key)))
