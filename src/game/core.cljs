(ns game.core
  (:require [reagent.core :as reagent]))

(defn board []
  [:div
   [:p
    [:span "o"][:span " "][:span "o"][:span " "][:span "o"]]
   [:p
    [:span "o"][:span " "][:span "o"][:span " "][:span "o"]]
   [:p
    [:span "o"][:span " "][:span "o"][:span " "][:span "o"]]])

(defn ^:export init []
  (reagent/render [board] (js/document.getElementById "app")))
