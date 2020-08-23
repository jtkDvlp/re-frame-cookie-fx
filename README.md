[![Clojars Project](https://img.shields.io/clojars/v/jtk-dvlp/re-frame-cookie-fx.svg)](https://clojars.org/jtk-dvlp/re-frame-cookie-fx)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://github.com/jtkDvlp/re-frame-cookie-fx/blob/master/LICENSE)

# Cookie effect handler for re-frame

This [re-frame](https://github.com/Day8/re-frame) library contains an cookie [effect handler](https://github.com/Day8/re-frame/tree/develop/docs). The handler can be addressed by `:cookie` and uses the [goog.net.cookies](https://google.github.io/closure-library/api/goog.net.Cookies.html) API.

## Getting started

### Get it / add dependency

Add the following dependency to your `project.cljs`:<br>
[![Clojars Project](https://img.shields.io/clojars/v/jtk-dvlp/re-frame-cookie-fx.svg)](https://clojars.org/jtk-dvlp/re-frame-cookie-fx)

### Usage

See the following minimal code example or the [test.cljs](https://github.com/jtkDvlp/re-frame-cookie-fx/blob/master/test/re_frame_cookie_fx/test.cljs).

```clojure
(ns your.project
  (:require [re-frame.core :as re-frame]
            [re-frame-cookie-fx.core]))

(re-frame/reg-event-fx
 :initialize
 ;; injects the cookie :re-frame-cookie-fx.core/db into your event handler
 [(re-frame/inject-cofx :cookie)]
 (fn [cofx _]
   ;; gets the current counter value from the cookie and / or creates it with the value 0
   {:cookie (update (:cookie cofx) :counter (fnil identity 0))}))
```

## Appendix

I´d be thankful to receive patches, comments and constructive criticism.

Hope the package is useful :-)
