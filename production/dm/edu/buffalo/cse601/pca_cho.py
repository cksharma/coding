import matplotlib.pyplot as plt
from sklearn.decomposition import PCA
import numpy as np;


fileName = 'E:\ctci_practise\PCA_KMeans_Ground_Cluster_Count_cho.txt';
title = 'cho.txt, k=5';
data = np.loadtxt(fileName);


X = data[:, 2:]
y = data[:,1]
n_components = min(X.shape[0], X.shape[1])

colors = ["r","g","b","y","c"]
clusters = [1,2,3,4,5]
target_names = ["Cluster"+ str(i) for i in range(1,6)]

pca = PCA(n_components=n_components)
X_r = pca.fit(X).transform(X)
print X_r[0]

plt.figure()
for c, i, target_name in zip(colors, clusters, target_names):
    plt.scatter(X_r[y == i, 0], X_r[y == i, 1], c=c, label=target_name)
    
plt.legend(bbox_to_anchor=(.87, 1), loc=2, borderaxespad=0.)
plt.title('PCA of '+title)
plt.show()