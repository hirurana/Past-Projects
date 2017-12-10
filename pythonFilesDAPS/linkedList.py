def empty():
    return None


def cons(list, item):
    return (item, list)


def head(list):
    return list[0]


def tail(list):
    return list[1]


def length(list):
    """Returns the number of items in the list"""
    if list == empty():
        return 0
    else:
        return 1 + length(tail(list))


def index(list, position):
    if list == empty():
        raise Exception("Out of bounds.")
    else:
        if position == 0:
            return head(list)
        else:
            return index(tail(list), position-1)
