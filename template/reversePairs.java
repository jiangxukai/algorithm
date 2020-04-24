int reversePairs(int[] a, int l, int r) {
    if (l + 1 >= r) return 0;
    int m = (r - l) / 2 + l;
    int cnt = reversePairs(a, l, m) + reversePairs(a, m, r);
    int[] tmp = new int[m-l];
    for (int i = 0; i < tmp.length; i++) {
        tmp[i] = a[l+i];
    }
    int i1 = 0, i2 = m, i3 = l;
    while (i1 < tmp.length && i2 < r) {
        if (tmp[i1] <= a[i2]) {
            a[i3++] = tmp[i1++];
        } else {
            cnt += m - l - i1;
            a[i3++] = a[i2++];
        }
    } 
    for (;i1 < tmp.length; i1++) {
        a[i3++] = tmp[i1];
    }
    return cnt;
}
