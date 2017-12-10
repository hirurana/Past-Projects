
def thief(objects, max_weight):
    """finding value using unbounded knapsack problem
        http://www.mathcs.emory.edu/~cheung/Courses/323/Syllabus/DynProg/knapsack2.html 
    """

    num_of_objects = len(objects)
    sub_solution = []
    combined_solution = []

    if not objects:
        raise IndexError("Empty list input")

    if max_weight < 0:
        raise ValueError("Cannot have negative max weight")
    elif max_weight == 0:
        return 0

    for object in objects:
        (weight, value) = object
        if weight <0 or value < 0:
            raise ValueError("Weights and values must be positive integers")

    for j in range(0, num_of_objects):
        if max_weight >= objects[j][0]:
            sub_solution.insert(j, thief(objects, (max_weight-objects[j][0])))
        else:
            sub_solution.insert(j, 0)

    for k in range(0, num_of_objects):
        if max_weight >= objects[k][0]:
            combined_solution.insert(k, (sub_solution[k] + objects[k][1]))
        else:
            combined_solution.insert(k, 0)
    print(sub_solution)
    # print(combined_solution)
    return max(combined_solution)


# add test cases and validation
items = [(2, 50), (3, 100), (5,20)]
print(thief(items, 10))


