(ns game.core
  (:require [re-frame.core :as rf]
            [reagent.core :as reagent]))

(rf/reg-event-db
  :init
  (fn [_ _] {:board [:o :o :o :o :o :o :o :o :o]}))

(rf/reg-sub
  :board
  (fn [db _] (:board db)))

(defn board-view []
  (let [[top-left top top-right
         mid-left mid mid-right
         bot-left bot bot-right] (map name @(rf/subscribe [:board]))]
    [:div
     [:p
      [:span top-left][:span " "][:span top][:span " "][:span top-right]]
     [:p
      [:span mid-left][:span " "][:span mid][:span " "][:span mid-right]]
     [:p
      [:span bot-left][:span " "][:span bot][:span " "][:span bot-right]]]))

(defn ^:export init []
  (rf/dispatch-sync [:init])
  (reagent/render [board-view] (js/document.getElementById "app")))
