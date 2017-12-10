import time


class LRUCacheWithTTL:
    # creates cache
    def __init__(self, size, ttl):
        self.size = size
        self.ttl = ttl
        self.slots = {}  # holds the key value pair
        self.access_times = {}  # holds the key and time the entry was updated/added

    # puts "value" into the cache with key "key"
    def put(self, key, value):
        self.validate()
        self.slots[key] = value
        self.access_times[key] = time.time()

    # returns value with key "key" from the cache
    # raises an exception if key is not in the cache
    def lookup(self, key):
        val = self.slots.get(key)
        if val is None:
            raise KeyError("Key is not in the cache")
        self.access_times[key] = time.time()
        return val

    # remove dead elements
    def validate(self):
        # flag used to check if there were any dead items to clear up
        dead_ele_removed = False
        for entry in self.access_times.items():
            # if the difference in time since validating and start time is > than time to live
            # then remove from dictionary
            if (time.time() - entry[1]) > self.ttl:
                dead_ele_removed = True
                del self.slots[entry[0]]
                del self.access_times[entry[0]]

        # if no dead items and the size of the list is equal to the max then remove the oldest entry
        if (not dead_ele_removed) and (len(self.slots) == self.size):
            # get the key of the oldest entry in the cache structure
            lru_key = min(self.access_times, key=lambda k: self.access_times[k])
            # delete it from the structure
            del self.access_times[lru_key]
            del self.slots[lru_key]

    def __iter__(self):
        return iter(self.slots.items())


def test_expected_answers():
    cache = LRUCacheWithTTL(2, 100)
    cache.put("foo", 20)
    element = cache.lookup("foo")
    assert element == "foo"


def test_invalid_lookup():
    cache = LRUCacheWithTTL(2, 100)
    cache.put("foo", 20)
    import pytest
    with pytest.raises(KeyError) as e_info:
        element = cache.lookup("doo")
    assert str(e_info.value) == "Key is not in the cache"

# def test_print_iterable():
#     cache = LRUCacheWithTTL(2, 100)
#     cache.put("foo", 20)
#     cache.put("bar", 15)
#     for e in cache:
#         print(e)
