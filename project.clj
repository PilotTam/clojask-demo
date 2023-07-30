(defproject clojask-demo "0.1.0-SNAPSHOT"
  :description "a demo for clojask"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :repl-options {:init (do (require '[clojure.core :refer :all :exclude [random-uuid]])
                           (clojure.core/refer 'clojure.core :exclude '[random-uuid]))
                 :init-ns clojask-demo.core}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [net.clojars.pilot "0.1.0"]
                 [io.aeron/aeron-client "1.40.0" :exclusions [org.agrona/agrona]]
                 [org.agrona/agrona "1.18.0"]
                 [io.aeron/aeron-all "1.40.0"]
                 [org.clojure/tools.analyzer "1.1.1"]]
  :jvm-opts ["--add-opens=java.base/sun.nio.ch=ALL-UNNAMED"
             "--add-opens=java.base/java.lang=ALL-UNNAMED"
             "--module-path=mods"
             "--add-modules=java.base"
             "--patch-module=java.base=mods/java.base"
             ]
  :profiles {:uberjar {:aot :all}}
  :mod {clojask-demo {
                   :requires [java.base]
                   :opens [java.lang]
                   :provides [clojure.main]
                   :requires-transitive [onyx.core]}})
