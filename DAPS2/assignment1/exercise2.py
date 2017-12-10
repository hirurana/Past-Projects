def thief_which(objects, max_weight):
    if max_weight < 0:
        raise Exception("Maximum weight must be greater than 0.")
    for object in objects:
        (weight, value) = object
        if weight < 0 or value < 0:
            raise Exception("Weights and values must be positive integers.")
    if max_weight == 0:
        return [0] * len(objects)

    objects_len = len(objects)
    dp = [0] * (max_weight + 1)
    stolen = [[0 for i in range(0, objects_len)] for j in range(0, max_weight + 1)]
    for i in range(1, max_weight + 1):
        for j in range(0, len(objects)):
            (weight, value) = objects[j]
            if weight <= i:
                newValue = dp[i - weight] + value
                if newValue > dp[i]:
                    dp[i] = newValue
                    for k in range(0, objects_len):
                        stolen[i][k] = stolen[i - weight][k]
                    stolen[i][j] += 1
    return stolen[max_weight]


def test_expected_answers():
    assert thief_which([(2,50), (3,100), (5,140)], 17) == [1, 5, 0]
    assert thief_which([(2,50), (3,100), (5,140)], 0) == [0, 0, 0]


def test_exceptions_raised():
    import pytest
    with pytest.raises(Exception) as e_info:
        thief_which([(1, 1)], -1)
    assert str(e_info.value) == "Maximum weight must be greater than 0."
    with pytest.raises(Exception) as e_info2:
        thief_which([(1, -1)], 0)
    assert str(e_info2.value) == "Weights and values must be positive integers."
    with pytest.raises(Exception) as e_info3:
        thief_which([(-1, 1)], 0)
    assert str(e_info3.value) == "Weights and values must be positive integers."
