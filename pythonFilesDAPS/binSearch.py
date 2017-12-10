def isin_bisect(seq, val):
    """ Returns True if val is within the sorted sequence seq. """
    range_start = 0
    range_end = len(seq)
    diff = range_end - range_start

    while diff > 1:
        range_mid = (range_start + range_end) // 2
        if seq[range_mid] <= val:
            range_start = range_mid
        else:
            range_end = range_mid
        assert diff > (range_end - range_start)  # Ensure progress
        diff = range_end - range_start

    return len(seq) > 0 and (seq[range_start] == val)


def isin_recursive(seq, val, start=0, end=None):
    end = end if end is not None else len(seq)  # if end is none set the value else leave it

    if not end - start > 1:
        return len(seq) > 0 and (seq[start] == val)

    mid = (start + end) // 2
    if seq[mid] <= val:
        return isin_recursive(seq, val, mid, end)
    else:
        return isin_recursive(seq, val, mid, end)