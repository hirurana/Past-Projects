
def thief(objects, max_weight):
    "finding value using knapsack problem"

    # these should be removed and access directly later
    values = []
    weights = []

    num_of_objects = len(objects)

    sub_solution = []
    combined_solution = []

    # create values list and weights list DELETEEEEEE
    for i in range(0,num_of_objects):
        values.append(objects[i][1])
        weights.append(objects[i][0])

    for j in range(0, num_of_objects):
        if max_weight >= weights[j]:
            sub_solution.insert(j, thief(objects, (max_weight-weights[j])))
        else:
            sub_solution.insert(j, 0)

    for k in range(0, num_of_objects):
        if max_weight >= weights[k]:
            combined_solution.insert(k, (sub_solution[k] + values[k]))
        else:
            combined_solution.insert(k, 0)

    return max(combined_solution)


lists = [(2,50), (3,100), (5,140)]


print(thief(lists, 17))
