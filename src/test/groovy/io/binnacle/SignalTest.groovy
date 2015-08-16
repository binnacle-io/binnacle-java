package io.binnacle

import spock.lang.*
import io.binnacle.client.Client
import org.json.JSONArray
import org.json.JSONObject


class SignalTest extends Specification {

    def "test simple signal call"() {
        setup:
            def API_KEY = '1slqyzcgdyp4mm1nj0ml'
            def API_SECRET = 'rwjvof9i9z4sxg6xf5t0'
            def client = new Client('bsttz0j8undbw2f0njr3', 'k030rxf5bd96eweqwd05', API_KEY, API_SECRET, 'http://localhost:8080')

        when:
            def node = client.signal('wamdnxroh90lehxgpvqp', 'event_from_client', 'binnacle-ruby', '001', 'INFO')

        then:
            println "test signal call>>> " + node
            assert (node instanceof JSONObject)
    }

    def "test simple async signal call"() {
        setup:
            def API_KEY = '1slqyzcgdyp4mm1nj0ml'
            def API_SECRET = 'rwjvof9i9z4sxg6xf5t0'
            def client = new Client('bsttz0j8undbw2f0njr3', 'k030rxf5bd96eweqwd05', API_KEY, API_SECRET, 'http://localhost:8080')

        when:
            client.signalAsync('wamdnxroh90lehxgpvqp', 'event_from_client', 'binnacle-ruby', '001', 'INFO')

        then:
            1 == 1
    }

    def "test simple recents call"() {
        setup:
            def API_KEY = '1slqyzcgdyp4mm1nj0ml'
            def API_SECRET = 'rwjvof9i9z4sxg6xf5t0'
            def client = new Client('bsttz0j8undbw2f0njr3', 'k030rxf5bd96eweqwd05', API_KEY, API_SECRET, 'http://localhost:8080')

        when:
            def node = client.recents('wamdnxroh90lehxgpvqp',  5)

        then:
            println "test recents call>>> " + node
            println "test recents lengths : ${node.length()}"
            assert (node instanceof JSONArray)
            assert node.length() > 1
    }
}