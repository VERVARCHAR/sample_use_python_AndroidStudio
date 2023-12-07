import numpy as np
# from __future__ import print_function
import torch
def create_random_number():
    return np.random.rand()

def sample_torch():
    x = torch.empty(5,3)
    b = x.numpy()
    ret = "SUCCESS"
    return ret